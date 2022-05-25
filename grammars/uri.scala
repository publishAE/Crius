import de.cispa.se.tribble.dsl._

Grammar(
  'start := 'translationUnit,
  'translationUnit := 'function,
  'function := "function" ~ 'identifier ~ 'arguments ~ 'block,
  //'function := "function" ~ 'identifier ~ 'arguments,
  'qualifiedIdentifier := 'identifier ~ (  "." ~ 'identifier).rep,
  'block := "{"  ~ ('blockStatement ).rep ~ "}",
  'blockStatement := 'variableDeclarator | 'statement,
  'variableDeclarator := 'identifier ~ ( "=" ~ 'expression ).rep(0,1) ~ ";",
  'statement := 'block
    | "if" ~ 'parExpression ~ 'statement ~ ( "else" ~ 'statement)
    //| "if" (~ "else" ~ 'statement)
    | "while" ~ 'parExpression ~ 'statement
    | "return" ~ ( 'expression ).rep(0,1) ~ ";"
    | 'expression ~ ";"
    | ";"
  ,
  'arguments := "(" ~ (  'expression ~ ( "," ~ 'expression ).rep).rep(0,1) ~ ")",
  'parExpression := "(" ~ 'expression ~ ")",
  'expression := 'assignmentExpression,
  'assignmentExpression := 'conditionalOrExpression ~ ("=" ~ 'assignmentExpression).rep(0,1),
  'conditionalOrExpression := 'conditionalAndExpression ~ ( "||" ~ 'conditionalAndExpression).rep,
  'conditionalAndExpression := 'equalityExpression ~ ("&&" ~ 'equalityExpression).rep,
  'equalityExpression :='relationalExpression ~ ( "==" ~ 'relationalExpression ~ "!=" ~ 'relationalExpression).rep,
  'relationalExpression := 'additiveExpression ~ (">" ~ 'additiveExpression | "<" ~ 'additiveExpression | ">=" ~'additiveExpression | "<=" ~ 'additiveExpression).rep(0,1),
  'additiveExpression := 'multiplicativeExpression ~ ("+" ~ 'multiplicativeExpression | "-" ~ 'multiplicativeExpression).rep,
  'multiplicativeExpression := 'primary ~( "*" ~ 'primary | "/" ~ 'primary).rep,
  'primary := 'parExpression | 'qualifiedIdentifier | 'identifier ~ 'arguments | 'identifier | 'literal,
  'literal := 'intLiteral | 'stringLiteral,
  'identifier := ("[a-zA-z]".regex | "_" | "$") ~ ( ("[a-zA-z]".regex | "_" | "$" | "[0-9]".regex)).rep,
  'intLiteral := "0" | "[1-9]".regex ~ ( "[0-9]".regex).rep,
  'stringLiteral := "\"" ~ ( 'ESC | "~[\\\"\\\n\\\r\\\\]".regex) ~ "\"" ,
  'ESC := "[\\\n\\\t\\\b\\\r\\\f\\\'\\\"\\\\]".regex
)
