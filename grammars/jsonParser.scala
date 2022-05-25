import de.cispa.se.tribble.dsl._

Grammar(
  'start := 'object,
  'object := "{" ~ 'collection ~ ( "," ~ 'collection).rep ~ "}",
  'collection := 'stringLiteral ~ ":" ~ 'value,
  'value := " " ~ ('object | 'array | "true" | "false" | "null" | 'stringLiteral | 'integerLiteral | 'floatPointLiteral) ~ " ",
  'array := "[" ~ 'value ~ ( "," ~ 'value).rep ~ "]",
  'integerLiteral := "[1-9]".regex ~ ( "[0-9]".regex ).rep,
  'floatPointLiteral := ("[0-9]".regex) ~ "."  ~ ("[0-9]".regex).rep ~ 'decExponent.?
    |"."~ "[0-9]".regex ~ 'decExponent.?
    |"[0-9]".regex ~ 'decExponent.?
    |"[0-9]".regex ~ 'decExponent,
  'decExponent := "[eE]".regex ~ "[+-]".regex ~ "[0-9]".regex,
  'stringLiteral := " \"" ~ ("[A-Za-z0-9!#$%&*+_-.;:<>,?~@`]".regex).rep ~ "\" "

)
