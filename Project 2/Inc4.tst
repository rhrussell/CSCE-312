load Inc4.hdl,
output-file Inc4.out,
compare-to Inc4.cmp,
output-list in%B1.4.1 out%B1.4.1;

set in %B0000,  // in = 0
eval,
output;

set in %B1111,  // in = -1
eval,
output;

set in %B0101,  // in = 5
eval,
output;

set in %B1011,  // in = -5
eval,
output;