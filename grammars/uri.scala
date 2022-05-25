import de.cispa.se.tribble.dsl._

//https://github.com/nbyouri/UriJavaCC/blob/master/src/uri.jj
Grammar(
  'start := 'translationUnit,
  'translationUnit := 'function,
  'function := " function " ~ 'identifier ~ 'arguments ~ 'block,
  //'function := "function" ~ 'identifier ~ 'arguments,
  'qualifiedIdentifier := 'identifier ~ (  "." ~ 'identifier).rep,
  'block := "{"  ~ 'blockStatement.rep ~ "}",
  'blockStatement := 'variableDeclarator | 'statement,
  'variableDeclarator := 'identifier ~ ( "=" ~ 'expression ).? ~ ";",
  'statement := 'block
    | " if " ~ 'parExpression ~ 'statement ~ ( " else " ~ 'statement).?
    | " while " ~ 'parExpression ~ 'statement
    | " return " ~ ( 'expression ).? ~ ";"
    | 'expression ~ ";"
  ,
  'arguments := "(" ~ (  'expression ~ ( "," ~ 'expression ).rep).? ~ ")",
  'parExpression := "(" ~ 'expression ~ ")",
  'expression := 'assignmentExpression,
  'assignmentExpression := 'conditionalOrExpression ~ ("=" ~ 'assignmentExpression).?,
  'conditionalOrExpression := 'conditionalAndExpression ~ ( "||" ~ 'conditionalAndExpression).rep,
  'conditionalAndExpression := 'equalityExpression ~ ("&&" ~ 'equalityExpression).rep,
  'equalityExpression :='relationalExpression ~ ( "==" ~ 'relationalExpression |"!=" ~ 'relationalExpression).rep,
  'relationalExpression := 'additiveExpression ~ (">" ~ 'additiveExpression | "<" ~ 'additiveExpression | ">=" ~'additiveExpression | "<=" ~ 'additiveExpression).?,
  'additiveExpression := 'multiplicativeExpression ~ ("+" ~ 'multiplicativeExpression | "-" ~ 'multiplicativeExpression).rep,
  'multiplicativeExpression := 'primary ~( "*" ~ 'primary | "/" ~ 'primary).rep,
  'primary := 'parExpression | 'qualifiedIdentifier | 'identifier ~ 'arguments | 'identifier | 'literal,
  'literal := 'intLiteral | 'stringLiteral,
  'identifier := " " ~ ("[a-zA-z]".regex | "_" | "$") ~ ("[a-zA-z]".regex | "_" | "$" | "[0-9]".regex).rep ~ " ",
  'intLiteral := " " ~  "0" | "[1-9]".regex ~ ( "[0-9]".regex).rep ~ " ",
  'stringLiteral := " " ~  "\"" ~ ( 'ESC | "~[\\\"\\\n\\\r\\\\]".regex).rep ~ "\"" ~ " ",
  'ESC := "[\\\n\\\t\\\b\\\r\\\f\\\'\\\"\\\\]".regex
)
