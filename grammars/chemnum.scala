import de.cispa.se.tribble.dsl._
// https://github.com/javacc/javacc/blob/master/docs/grammars/ChemNumber.jj
Grammar(


  'wholeNumber := 'specialCase | 'allBaseNumbers ~ ('tensWithUnits | 'tensNoUnits),
  'specialCase := 'METH | 'ETH| 'PROP| 'BUT |'UNDEC | 'EICOS | 'HENICOS,
  'allBaseNumbers := 'HEN | 'DO | 'TRI | 'TETR | 'PENT | 'HEX | 'HEPT | 'OCT | 'NON,
  'tensNoUnits := 'DEC | 'COS  |'CONT,
  'tensWithUnits := 'allBaseNumbers ~ 'CONT,

  'METH    := "meth",
  'ETH     := "eth" ,
  'PROP    := "prop" ,
  'BUT     := "but" ,
  'UNDEC   := "undec" ,
  'EICOS   := "eicos" | "icos" ,
  'HENICOS := "henicos" ,
  'HEN     := "hen" ,
  'DO      := "do" ,
  'TRI     := "tri" ,
  'TETR    := "tetra" ,
  'PENT    := "pent" ,
  'HEX     := "hex" ,
  'HEPT    := "hept" ,
  'OCT     := "oct" ,
  'NON     := "non" ,
  'DEC     := "dec" ,
  'COS     := "cos" ,
  'CONT    := "cont"
)
