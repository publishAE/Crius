import de.cispa.se.tribble.dsl._

//https://github.com/abcdw/javacc-clojure/blob/master/Clojure.jj
Grammar(

  'start := 'forms,

  'forms := 'form.rep,

  'form :=  ( 'literal
    | 'symbol
    | 'list
    | 'vector
    | 'set
    | 'map
    | 'reader_macro) ~ " ",

  'list := 'LPAR ~ 'forms ~ 'RPAR,
  'vector := 'LSQU ~ 'forms ~ 'RSQU,
  'set := "#" ~ 'LCUR ~ 'forms ~ 'RCUR,
  'map := 'LCUR ~ ('form ~ 'form).rep ~ 'RCUR,

  'symbol := 'SYMBOL,
  'literal := 'KEYWORD | 'CHARACTER | 'NUM | 'NIL | 'STR | 'BOOLEAN,
  'reader_macro := 'quote | 'lambda | 'regex | 'var_quote | 'discard | 'tag | 'meta,
  'quote := ("\'" | "`" | "~" | "~@" | "@" ) ~ 'form,
  'lambda := "#(" ~ 'forms ~ ")",
  'regex :=  "#"  ~ 'STR,
  'var_quote := "#\'" ~ 'symbol,
  'discard := "#_" ~ 'form,
  'tag :=  "^" ~ 'form ~  'form,
  'meta := "#^" ~ (('map ~ 'form) | 'form),

  
  'LPAR:= "(",
  'RPAR:= ")",
  'LSQU:= "[",
  'RSQU:= "]",
  'LCUR:= "{",
  'RCUR:= "}",
          
  'NUM:= 'RATIO | 'INT | 'DOUBLE,
  'RATIO:= 'INT ~ "/" ~ 'INT ,
  'DOUBLE := 'DIGIT.rep(1) ~ "." ~ ('DIGIT.rep) ~ ("e" ~ 'DIGIT.rep(1) ).?,
  'INT := 'DIGIT.rep(1) ~ ("r" ~ 'DIGIT.rep(1)).? ~ ("n" | "l" | "L" | "N").?,
  'NIL:= "nil",
  'STR:= "\"" ~ ("~[\"]".regex | "\\" ~ "\"").rep ~ "\"",
  'BOOLEAN:= "true" | "false",
  'CHARACTER:= "\\" ~  ("~[ ]".regex
  | ("u" ~ 'DIGIT ~'DIGIT ~'DIGIT ~'DIGIT)
  | ("o" ~ 'DIGIT ~'DIGIT ~'DIGIT)
  | "newline"
  | "space"
  | "tab"
  | "formfeed"
  | "backspace"
  | "return") ,
  
  'KEYWORD:= ":" ~ ":".? ~ ('DIGIT.rep ~ 'NS ~ "/").? ~ 'DIGIT.rep ~ 'NAME,
                        
  'SYMBOL:= 'NAME | 'NS | 'NS ~ "/" ~ 'NAME | 'INTEROP,
  'INTEROP:= ((("." | ".-") ~ 'NAME) | "." ),
  'NS:= 'NAME ~ ("." ~ 'NAME).rep,
  'NAME:= ('LETTER | 'CHAR) ~ ('DIGIT | 'LETTER | 'CHAR | "#" | "'" ).rep ,
  'LETTER:= "[a-zA-Z]".regex,
  'CHAR:= "*"| "+"| "!"| "-"| "_"| "?"| "="| "%"| "&"| ">"| "<"| "$" , // maybe some other chars
  'DIGIT:= "[0-9]".regex
//  'ws := "[0-9A-Fa-f]".regex

)
