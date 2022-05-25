import de.cispa.se.tribble.dsl._
//https://github.com/gtxistxgao/SQLParser/blob/master/src/SQLParser.jj
Grammar(
  'start := 'sfwStatement,
  'sfwStatement := 'selectClause ~ 'fromClause ~ 'whereClause,
  'selectClause := "SELECT " ~ 'attr,
  'attr := 'name ~ "." ~ 'name ~ (  "," ~ 'attr).rep,
  'fromClause := " FROM " ~ 'relVal,
  'relVal := 'name ~ " " ~ 'name ~ ("," ~ 'relVal).rep,
  //this rule has been modified as javacc prefer us to use LOOKAHEAD
//  'relVal := 'name ~ " " ~'name,
  'whereClause := " WHERE " ~ 'expression,
  'expression := "(" ~ 'expression ~ ")" ~ (" AND " ~ 'expression).rep |'factor ~ (" AND " ~ 'expression).rep,
  'factor := 'booleanAttr ~ 'operator ~ 'booleanAttr,
  'booleanAttr := 'digits | 'name ~ "." ~ 'name | "\"" ~ 'name ~ "\"",
  'operator := " > " | " < " | " = " | " >= " | " <= " |" <> " | " != ",
  'name := "[a-z0-9]".regex.rep(1),
  'digits :="[0-9]".regex.rep(1)

)
