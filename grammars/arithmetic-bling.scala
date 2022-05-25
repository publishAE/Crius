import de.cispa.se.tribble.dsl._

Grammar(
	'Start := 'Expression ,
  
	//< PLUS : "+" > | < MINUS: "-" >| < STAR : "*" >| < SLASH : "/" >| < CARAT : "^" >| < LPAREN : "(" > | < RPAREN : ")" > 
	// | < NUMBER :(["0"-"9"])+("."(["0"-"9"])+)? (["e","E"](["+","-"])?(["0"-"9"])+)?>
	'PLUS :=  "+" ,
	'MINUS := "-" ,
	'STAR :=  "*" ,
	'SLASH := "/" ,
	'CARAT := "^" ,
	'LPAREN:= "(" ,
	'RPAREN:= ")" ,
	'NUMBER:= ("[0-9]".regex).rep(1,5) ~ ("." ~ ("[0-9]".regex).rep(1,5)).? ~ (("e"|"E") ~ ("+"|"-").? ~ ("[0-9]".regex).rep(1,5) ).? ,
	
	'Expression := 'AdditiveExpression ,
	'AdditiveExpression := 'MultiplicativeExpression ~ " " ~('MINUS|'PLUS)~ " " ~ 'MultiplicativeExpression ,
	'MultiplicativeExpression := 'ExponentialExpression ~ " " ~ ('STAR|'SLASH) ~ " " ~ 'ExponentialExpression ,
	'ExponentialExpression := 'LPAREN ~ 'NegatableExpression ~ " " ~ 'CARAT ~ " " ~ 'NegatableExpression ~ 'RPAREN ,
	'NegatableExpression := 'MINUS.? ~ 'PrimeExpression ,
	'PrimeExpression := 'NumberLiteral | 'GroupedExpression ,
	'NumberLiteral := " " ~ 'NUMBER ~ " "  ,
	'GroupedExpression := 'LPAREN ~ 'AdditiveExpression ~ 'RPAREN
)
