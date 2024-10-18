package ru.antonov.laba_1

import java.util.TreeSet

class MyTextEditor : TextEditor {
    override fun deleteWords(words: List<String>, len: Int): Set<String> {
        val result = TreeSet<String>()

        for(w in words){
            if(w.length != len)
                result.add(w)
        }

        return result
    }

}