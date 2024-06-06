class Autocorrect:
    def __init__(self, dictionary):
        self.dictionary = dictionary

    def correct(self, word):
        return difflib.get_close_matches(word, self.dictionary, n=1, cutoff=0.6)[0]