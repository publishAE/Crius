import multiprocessing
import subprocess
import sys

modeName = ['final', 'token', 'GADSE', 'DSE', 'exchange_GADSE']

def recall(bench, mode):
    command = "pypy3.7-v7.3.3-linux64/bin/pypy eval_larkgram.py results/%s/%s.lark test-set/%s/* > results/%s/%s-recall" %(bench, modeName[mode], bench, bench, modeName[mode])
    subprocess.call(command, shell=True, stdout=open('/dev/null', 'w'), stderr=subprocess.STDOUT)

if __name__ == '__main__':
    process_num = 10
    list_of_arguments = sys.argv
    if len(list_of_arguments) > 1:
        process_num = int(list_of_arguments[1])

    pool1 = multiprocessing.Pool(processes=process_num)
    for bench in ["bling", "chemnum", "clojure", "curta", "firstOrder", "uri", "sixpath", "jsonmwn", "jsonParser"]:
        for mode in range(5):
            pool1.apply_async(recall, (bench, mode))
    pool1.close()
    pool1.join()