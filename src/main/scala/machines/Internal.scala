package machines

import regex._
import dfa._
import scala.Conversion
import machines.given

// Conversion for Part 1
given Conversion[Char, Character] = Character(_)

// Conversion for Part 2
given Conversion[String, RegularLanguage] with
    def apply(s: String): RegularLanguage = 
        s.length() match
            case 0 => Empty
            case 1 => Character(s.head)
            case otherwise => Concat(s.head, s.tail)