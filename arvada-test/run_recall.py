
import subprocess
import datetime
import multiprocessing
import sys


def recall(bench, round):
    command0 = "../pypy3.7-v7.3.3-linux64/bin/pypy arvada/eval.py external ./benchmarks/%s/parser.sh benchmarks/%s/test_set arvada-results/GADSE_%s_%d.log" %(bench, bench, bench, round)
    command1 = "../pypy3.7-v7.3.3-linux64/bin/pypy arvada/eval.py external ./benchmarks/%s/parser.sh benchmarks/%s/test_set arvada-results/DSE_%s_%d.log" %(bench, bench, bench, round)
    subprocess.call(command0, shell=True, stdout=open('/dev/null', 'w'), stderr=subprocess.STDOUT)
    subprocess.call(command1, shell=True, stdout=open('/dev/null', 'w'), stderr=subprocess.STDOUT)


if __name__ == '__main__':
    process_num = 10
    list_of_arguments = sys.argv
    if len(list_of_arguments) > 1:
        process_num = int(list_of_arguments[1])

    pool0 = multiprocessing.Pool(processes=process_num)

    for bench in ["bling","chemnum","clojure","curta", "firstOrder", "uri", "Sixpath", "Jsonmwn", "JsonParser"]:
        for round in range(10):
            pool0.apply_async(recall, (bench,round))
    pool0.close()
    pool0.join()
