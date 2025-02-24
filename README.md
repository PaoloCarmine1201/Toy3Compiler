#Toy3 Compiler

##Project Description

###Compiler written in Java that translates programs from the fictional Toy3 language into C.
###Produced for the Compilers course of Computer Science at University of Salerno.

#Technical Specifications

Program ::= PROGRAM Decls BEGIN VarDecls Statements END

/* Dichiarazione */
Decls ::= VarDecl Decls 
          | DefDecl Decls 
          | /* epsilon */

/* Dichiarazione di variabili */
VarDecls ::= VarDecls VarDecl 
           | /* epsilon */

//lista di varoptinit
VarDecl ::= VarsOptInit COLON TypeOrConstant SEMI

VarsOptInit ::= ID PIPE VarsOptInit
              | ID ASSIGNDECL Expr PIPE VarsOptInit
              | ID
              | ID ASSIGNDECL Expr

/* Tipi e costanti */
TypeOrConstant ::= Type
                 | Constant

Type ::= INT 
       | BOOL
       | DOUBLE
       | STRING 
       | CHAR 

Constant ::= TRUE
           | FALSE
           | INT_CONST
           | DOUBLE_CONST
           | CHAR_CONST
           | STRING_CONST

/* Dichiarazione di funzioni */
DefDecl ::= DEF ID LPAR ParDecls RPAR OptType Body
          | DEF ID LPAR RPAR OptType Body

ParDecls ::= ParDecl SEMI ParDecls
           | ParDecl

ParDecl ::= PVars COLON Type

PVars ::= PVar COMMA PVars
        | PVar

PVar ::= ID
       | REF ID

/* Corpo del programma */
OptType ::= COLON Type
          | /* epsilon */

Body ::= LBRAC VarDecls Statements RBRAC

/* Statements */
Statements ::= Stat Statements
             | /* epsilon */

Stat ::= Vars IN SEMI
       | Exprs OUT SEMI
       | Exprs OUTNL SEMI
       | Vars ASSIGN Exprs SEMI
       | FunCall SEMI 
       | IF LPAR Expr RPAR THEN Body ELSE Body
       | IF LPAR Expr RPAR THEN Body
       | WHILE LPAR Expr RPAR DO Body
       | RETURN Expr SEMI

/* Espressioni */
Vars ::= ID PIPE Vars
       | ID

Exprs ::= Expr COMMA Exprs
        | Expr

FunCall ::= ID LPAR Exprs RPAR 
          | ID LPAR RPAR 

Expr ::= Expr PLUS Expr
       | Expr MINUS Expr
       | Expr TIMES Expr
       | Expr DIV Expr
       | Expr AND Expr
       | Expr OR Expr
       | Expr GT Expr
       | Expr GE Expr
       | Expr LT Expr
       | Expr LE Expr
       | Expr EQ Expr
       | Expr NE Expr
       | LPAR Expr RPAR
       | MINUS Expr
       | NOT Expr
       | ID
       | FunCall
       | Constant
