# Crius Replication Package
This repository  contains the materials to replicate the experiment from the paper "Token-based Synthesis of Input Grammars". 
Crius is a token-based synthesis method for learning input grammars.

## Docker
With Docker , all the installation steps are automatically performed, creating a complete environment that can replicate the experiments.
Assuming you have Docker installed, simply run:
```
$ docker build -t crius-artifact .
$ docker run -it crius-artifact
```
## Prerequisites
Crius has been tested on Ubuntu 14 and above. Because Crius is written in Java and does not rely on additional libraries, it can theoretically run on any operating system. Crius requires **JAVA 1.8** or above.  
We have provided the jar package for crius, so there is no need to compile again. 

## Starting the experiments
The full experiments can be re-run via   
```
./run_all.sh
```
Crius and glade based methods will run on each benchmark three times, record the precision and the synthesis time, and then evaluate the resulted grammar. Then run Arvada, let it run ten times on each benchmark, and then evaluate the resulted grammar.
This stores all the results for Crius and glade based methods in `results` and for Arvada in `arvada-test/arvada-results`. 

Running a complete experiment takes a long time，because the evaluation of some methods is time-consuming. In addition, Arvada runs slowly and needs to be run ten times. In order to save time, we choose 10 processes running in parallel by default. We recommend that the machine be configured with 32G RAM and 16vCPU to run our default experimental settings. And you can flexibly select the number of parallel processes according to your machine configuration. 

`NUM_PROCESSES` : set this to the number of parallel processes you want to run (it is 10 by default).

For example, 
```
$ NUM_PROCESSES=1 ./run_all.sh
```
in this way, only one process is executing the task at a time.

If you just want to run only Crius and glade related methods, you can use this command (The last number 10 means running 10 tasks in parallel. You can give different parameter values as needed)
```
$ pypy3.7-v7.3.3-linux64/bin/pypy3 run_bench.py 10
$ pypy3.7-v7.3.3-linux64/bin/pypy3 run_recall.py 10
```
The first command is used to synthesis grammar for each benchmark, the second one is to evaluate the resulted grammars.
Similarly, if you only want to run Arvada， you can use this command
```
$ cd arvada-test
$ ../pypy3.7-v7.3.3-linux64/bin/pypy3 run.py 10
$ ../pypy3.7-v7.3.3-linux64/bin/pypy3 run_recall.py 10
```

## Structure
The following are the important files
* `Crius.jar`: It contains the algorithm implementation and benchmark programs. 
* `train_set`: the training set of examples which generated from token-level concolic execution
    * `tokenBound`: the character-level constraints of each token and the character-level seeds of each token
    * `tokenList`: the set of of token sequences
* `train_set_DSE` : the training set of examples which generated from concolic execution
* `test-set` :　the set of testing examples
* `grammars` :　the ground-truth grammar for each benchmark program
* `arvada-test`: the folder for evaluation of arvada
    * `arvada`　: arvada algorithm implementation
    * `benchmarks` : all benchmarks and each corresponding training and test data

## Running Crius
You can run Crius via
```
$ java -cp Crius.jar TestBench BENCH_NAME 0 
```
The optional `BENCH_NAME` argument specifies which benchmark will be used. The last number 0 means we use Crius as our synthesis method. You can change it to 2, which means use Glade as synthesis method. We have nine benchmarks in our evaluation. You can pick `BENCH_NAME` from this list [`bling`, `chemnum`, `clojure`, `curta`, `firstOrder`, `uri`, `sixpath`, `jsonmwn`,`jsonParser`]. 
For example, we can use Crius to sysnthesis jsonmwn's grammar via
```
$ java -cp Crius.jar TestBench jsonmwn 0 
```
this will store the learned grammar in `results/jsonmwn/final.lark`. You can also know the presicion and synthesis time from `results/jsonmwn/time&presicion`.

You can also evaluate the recall of the learned grammar via
```
$　pypy3.7-v7.3.3-linux64/bin/pypy eval_larkgram.py results/BENCH_NAME/final.lark test-set/BENCH_NAME/* > recall.log
```
`BENCH_NAME` in this command is the same as described above. You can replace `BENCH_NAME` with the name of the benchmark you want to run. Then you can see the evaluation details in the file recall.log.