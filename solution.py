Here is a simple Python console application that simulates a typing autocorrect system using a dictionary. This application uses the `difflib` library to find the closest match to the input word from the dictionary.

```python
import difflib

class Autocorrect:
    def __init__(self, dictionary):
        self.dictionary = dictionary

    def correct(self, word):
        return difflib.get_close_matches(word, self.dictionary, n=1, cutoff=0.6)[0]

def main():
    dictionary = ['hello', 'world', 'python', 'programming', 'autocorrect', 'system', 'dictionary']
    autocorrect = Autocorrect(dictionary)

    while True:
        word = input("Type a word: ")
        if word == 'exit':
            break
        print("Did you mean: ", autocorrect.correct(word))

if __name__ == "__main__":
    main()
```

In this application, you can type a word and it will suggest the closest word from the dictionary. If you want to exit the application, just type 'exit'. The `difflib.get_close_matches` function is used to find the closest matches to the input word from the dictionary. The `n` parameter specifies the maximum number of close matches to return and the `cutoff` parameter is a float in the range [0, 1] that specifies the required similarity ratio to consider a word as a close match.