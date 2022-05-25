import de.cispa.se.tribble.dsl._

Grammar(
	'start := 'formula,
	'formula := 'atomic	| 'negated | 'existential | 'universal | 'binary,
	'existential := "exists" ~ 'variable ~ "." ~ 'formula,
	'universal := "forall" ~ 'variable ~ "." ~ 'formula,
	'negated := "!" ~ 'formula,
	'binary := "(" ~ 'formula ~ ("->" ~ 'formula ~ ")" | "|" ~ 'formula ~ ")" | "&" ~ 'formula ~ ")" ),
	'atomic := 'id ~ 'tuple,
	'term := 'variable | 'id  ~ 'tuple.?,
	'tuple := "(" ~ 'term  ~ ( "," ~ 'term ).rep ~ ")",
	//'ws := "[ \\\n\\\r\\\t\\\f]".regex,
	'variable := "[A-Z]".regex ~ ("[A-Z]".regex | "_" | "[a-z]".regex | "[0-9]".regex ).rep,
	'id := "[a-z]".regex ~ ("[A-Z]".regex | "_" | "[a-z]".regex | "[0-9]".regex ).rep
)
