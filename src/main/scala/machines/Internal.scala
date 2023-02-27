package machines

import regex._
import dfa._
import scala.Conversion
import machines.given
import machines._

// Conversion for Part 1
given Conversion[Char, RegularLanguage] = Character(_)

// Conversion for Part 2
given Conversion[String, RegularLanguage] with
    def apply(s: String): RegularLanguage = 
        s.length() match
            case 0 => Empty
            case 1 => Character(s.head)
            case otherwise => Concat(s.head, s.tail)

// Operator implementation for Part 3
extension(lang1: RegularLanguage)
    def ||(lang2: RegularLanguage) = Union(lang1, lang2)
    def ~(lang2: RegularLanguage) = Concat(lang1, lang2)
    def <*> = Star(lang1)
    def <+> = Concat(lang1, Star(lang1))
    def apply(n: Int): RegularLanguage = 
        if (n == 0) then Empty
        else if (n == 1) then lang1
        else Concat(lang1, (lang1(n-1)))
    def toDFA:DFA = regexToDFA(lang1, chars(lang1))

// Helper function to extract chars for regextoDFA
def chars(lang: RegularLanguage): Set[Char] =
    lang match
        case Empty => Set()
        case Epsilon => Set()
        case Character(c) => Set(c)
        case Union(r1, r2) => (chars(r1) ++ chars(r2))
        case Concat(r1,r2) => (chars(r1) ++ chars(r2))
        case Star(r) => chars(r)

given Conversion[RegularLanguage, DFA] with
    def apply(r: RegularLanguage): DFA = (r toDFA)