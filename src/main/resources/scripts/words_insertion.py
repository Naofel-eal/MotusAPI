import os
import sys
import psycopg2
from dotenv import load_dotenv

def get_language_id(cursor, language_code):
    cursor.execute("SELECT language_id FROM language WHERE language_iso_code = %s", (language_code,))
    result = cursor.fetchone()
    if result:
        return result[0]
    else:
        print(f"Language code {language_code} not found in database.")
        return None

def insert_word(cursor, language_id, word):
    cursor.execute("INSERT INTO word (word_language_id, word_value) VALUES (%s, %s)", (language_id, word))

def process_file(file_path, cursor):
    language_code = os.path.splitext(os.path.basename(file_path))[0].upper()
    language_id = get_language_id(cursor, language_code)
    if language_id is None:
        return
    
    with open(file_path, 'r', encoding='utf-8') as file:
        for word in file:
            word = word.strip()
            if word:
                insert_word(cursor, language_id, word)

def main(env_file_path, file_path):
    load_dotenv(dotenv_path=env_file_path)

    dbname = os.getenv("DB_NAME")
    user = os.getenv("DB_USER")
    password = os.getenv("DB_PASSWORD")
    host = os.getenv("DB_HOST")

    conn = psycopg2.connect(dbname=dbname, user=user, password=password, host=host)
    cursor = conn.cursor()

    try:
        process_file(file_path, cursor)
        conn.commit()
    except Exception as e:
        print(f"An error occurred: {e}")
        conn.rollback()
    finally:
        cursor.close()
        conn.close()

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python words_insertion.py <path_to_env_file> <path_to_word_file>")
        sys.exit(1)

    env_file_path = sys.argv[1]
    file_path = sys.argv[2]
    main(env_file_path, file_path)
