package ru.aleksandra.laba_1

interface TextEditor {
    fun deleteWords(words : List<String>, len : Int ) : Set<String>
}