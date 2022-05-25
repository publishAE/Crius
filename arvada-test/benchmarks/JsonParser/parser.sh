#!/bin/bash

# Returns 0 if bc executed correctly with no syntax errors; returns 1 if there was a syntax error.

filename=$1
path="$PWD"
java -cp $PWD/benchmarks/MyTask.jar test.TestJsonparser $filename