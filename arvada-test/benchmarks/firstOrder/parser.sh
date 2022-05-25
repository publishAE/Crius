#!/bin/bash

filename=$1
path="$PWD"
java -cp $PWD/benchmarks/MyTask.jar test.TestFirstOrder $filename