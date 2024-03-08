import sys
import re

def is_valid(word):
    return bool(re.match('^[A-Za-z]+$', word))


def main():
    if len(sys.argv) != 2:
        print("Usage: python normalize_words.py file_path")
        sys.exit(1)
    
    file_path = sys.argv[1]

    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            words = file.readlines()
    except FileNotFoundError:
        print(f"File {file_path} not found.")
        sys.exit(1)

    filtered_words = [word for word in words if is_valid(word.strip())]

    with open(file_path, 'w', encoding='utf-8') as file:
        for word in filtered_words:
            file.write(word.lower())

    print(f"Words have been filtered and {file_path} has been updated.")

if __name__ == "__main__":
    main()