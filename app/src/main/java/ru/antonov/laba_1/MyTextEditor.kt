package ru.antonov.laba_1


class MyTextEditor : TextEditor {
    override fun deleteWords(words: List<String>, len: Int): Set<String> {
        return words.filter{ it.length != len}.toSortedSet()
    }
}