#!/bin/bash

PYTHON=pypy3.7-v7.3.3-linux64/bin/pypy3

if [ ! -z "${NUM_PROCESSES}" ]; then
	if [ 1 -gt $NUM_PROCESSES ]; then
		echo "NUM_PROCESSES must be an integer greater than or equal to 1"
		exit 1
	fi
	MAX_PRO=$NUM_PROCESSES
else
	MAX_PRO=10
fi

# # run crius and other glade based method
# $PYTHON run_bench.py $MAX_PRO
# # evaluation
# $PYTHON run_recall.py $MAX_PRO


# run arvada
cd arvada-test && ../$PYTHON run.py $MAX_PRO
# evaluation
cd arvada-test && ../$PYTHON run_recall.py $MAX_PRO
