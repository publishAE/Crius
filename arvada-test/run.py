#!/usr/bin/python
import threading
import subprocess
import datetime
import multiprocessing
import sys

def synthesis(bench, round) :
    command0 = "../pypy3.7-v7.3.3-linux64/bin/pypy arvada/search.py external ./benchmarks/%s/parser.sh benchmarks/%s/GADSE_train_set arvada-results/GADSE_%s_%d.log" %(bench,bench,bench,round)
    command1 = "../pypy3.7-v7.3.3-linux64/bin/pypy arvada/search.py external ./benchmarks/%s/parser.sh benchmarks/%s/DSE_train_set arvada-results/DSE_%s_%d.log" %(bench, bench, bench, round)
    print(command0)
    # command0 = "echo 0 > %s_%i.log" %(bench,round)
    # command1 = "echo 0 > dse_%s_%i.log" %(bench,round)
    subprocess.call(command0, shell=True, stdout=open('/dev/null', 'w'), stderr=subprocess.STDOUT)
    subprocess.call(command1, shell=True, stdout=open('/dev/null', 'w'), stderr=subprocess.STDOUT)



if __name__ == '__main__':
    process_num = 10
    list_of_arguments = sys.argv
    if len(list_of_arguments) > 1:
        process_num = int(list_of_arguments[1])

    pool = multiprocessing.Pool(processes=process_num)

    for bench in ["bling","chemnum","clojure","curta", "firstOrder", "uri", "Sixpath", "Jsonmwn", "JsonParser"]:
        for round in range(10):
            pool.apply_async(synthesis, (bench,round))
    pool.close()
    pool.join()



