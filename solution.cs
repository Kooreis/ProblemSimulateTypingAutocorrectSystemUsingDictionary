Here is a simple console application in C# that simulates a typing autocorrect system using a dictionary:

```C#
using System;
using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        Dictionary<string, string> dictionary = new Dictionary<string, string>
        {
            { "hte", "the" },
            { "adn", "and" },
            { "tihng", "thing" },
            { "youre", "you're" }
        };

        Console.WriteLine("Enter a sentence:");
        string input = Console.ReadLine();

        string[] words = input.Split(' ');

        for (int i = 0; i < words.Length; i++)
        {
            if (dictionary.ContainsKey(words[i]))
            {
                words[i] = dictionary[words[i]];
            }
        }

        string correctedSentence = string.Join(" ", words);

        Console.WriteLine("Corrected sentence:");
        Console.WriteLine(correctedSentence);

        Console.ReadKey();
    }
}
```

This program takes a sentence as input, splits it into words, and checks each word against a dictionary of common misspellings. If a word is found in the dictionary, it is replaced with the correct spelling. The corrected sentence is then displayed.