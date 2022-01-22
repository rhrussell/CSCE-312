load Negation4.hdl,
output-file Negation4.out,
compare-to Negation4.cmp,
output-list in%B1.4.1 out%B1.4.1;

//in=1
set in %B0001,
eval,
output;

//in=255
set in %B0011,
eval,
output;

//in=256
set in %B0100,
eval,
output;

//in=-1
set in %B1111,
eval,
output;