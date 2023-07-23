# Groovy
Groovy syntax check-up, by writing a calculator with flexible operation-oriented functions;

Flexibility is achieved due to `Chain-of-responsibility` internal usage
the math operations combined in the sequential chain, that's how prioritizing mathematical operations keeps on.

for example expression: 
2+3((5/4) - 2) * 5
will be parsed like this
 1. find the "deepest" expression in brackets (5/4)
 2. start searching for "higher" level brackets and apply operations
 3. when the brackets are finished, start execution of the operation in order to Math priority for `* / + -`  
