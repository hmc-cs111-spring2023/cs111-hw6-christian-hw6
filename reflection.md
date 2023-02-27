# Reflection on implementing regular expressions of a DSL

## Which operators were easiest to implement and why?
The easiest operators to implement were the Union and Concat operators, 
this is because it followed the syntax of the assignments we worked on 
in class and the prior homework so it just was essentially remapping the 
operator to a symbol.

## Which operators were most difficult to implement and why?
The most difficult operator to implement was the repetition operator {n}.
This is because the format was unique since there was no method being called
as was the case with the prior operators, it was only a number, which varied
and a set of curly braces, which cannot be used to define a method in Scala.
However, I read over Scala documentation and learned about how apply works 
and that was very helpful as it allowed me to focus on the implementation of 
the method, which I understood would just be a recursive call decrementing n.

## Comment on the design of this internal DSL
One thing I particularly like about this design is that it follows the 
convention of symbol operators. This really reduces the length of operations 
with regex expressions. However, it is important to note that this sleek design 
also could be more difficult to interpret for people who do not know the meaning 
of the symbols or beginners to regular language expressions. I think that this 
demonstrates how useful good documentation can be for DSLs because the sleek 
design creates a better user experience than having to manually write out the 
expressions as we did in the last homework, but it is dependent on the user's 
familiarity with the DSL.

An issue with this design is that it does slightly vary from the usual conventions 
for these operations, such as concat not being represented by the dot operator. 
This also makes the language slightly more cumbersome because instead of being able 
to just use a symbol like *, users have to use <*>. This seems like something which 
is relatively easy to change with Scala as there would not be any features of Scala 
preventing this change and it would further benefit the readability for users 
familar with regualr language expressions. However, that would also come with a 
drawback of those symbols being difficult to type since they are not on traditional 
keyboards.