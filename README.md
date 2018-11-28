# EpochX

Source code of the modified EpochX (version 1.4.1) framework for the Automated Multi-Label Classification (Auto-MLC) project. The original code is available at https://www.epochx.org/ and https://github.com/tc33/EpochX.


**Main differences to the original version:**

1) It allows the generation of random float numbers (from a range) into the production rules, by using "RANDFLOAT(0.0,1.0)";
2) It allows the generation of random integer numbers (from a range) into the production rules, by using "RANDINT_TYPE0(1,64)";
3) It allows the generation of random integer numbers (from a range) into the production rules, restricted by the square root of the number of class labels plus one, by using "RANDINT_TYPE1(1,SQRT(L)+1)";
4) It allows the generation of random integer numbers (from a range) into the production rules, restricted by the number of class labels divided by two, by using "RANDINT_TYPE2(1,L/2)"; 
5) It allows the generation of random integer numbers (from a range) into the production rules, restricted by the minimum value between 100 and two times the number of class labels, by using "RANDINT_TYPE3(2,min(2L;100))";  
6) It allows the generation of random integer numbers (from a range) into the production rules, restricted by the range from 20% to 100% of the number of attributes of the problem, by using "RANDINT_TYPE4((0.2,1.0)*n_attributes)"; 
7) It allows the generation of random integer numbers (from a range) into the production rules, restricted by the number of class labels of the problem, by using "RANDINT_TYPE5(1,L)";  
8) It allows the generation of random integer numbers (from a range) into the production rules, restricted by the number of class labels minus one (1), by using "RANDINT_TYPE6(2,L-1)"; 
9) Because of legibility issues of the grammar, we automatically add space to separate the produced terminals. Hence, the user that will create the grammar does not need to add " " after each terminal and non-terminal.
10) Removal of code not related to grammar-based genetic programming (GGP).


**If you are using this framework, please cite its paper:**

=> Fernando Otero, Tom Castle, and Colin Johnson. 2012. EpochX: genetic programming in java with statistics and event monitoring. In Proceedings of the 14th annual conference companion on Genetic and evolutionary computation (GECCO '12), Terence Soule (Ed.). ACM, New York, NY, USA, 93-100. DOI: https://doi.org/10.1145/2330784.2330800







