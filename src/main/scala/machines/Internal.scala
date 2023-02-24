package machines

import regex._
import dfa._
import scala.Conversion
import machines.given

given Conversion[Char, Character] = Character(_)