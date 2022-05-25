import multiprocessing
import subprocess
import sys

def synthesis(bench, mode) :
    command = "java -cp glade.jar TestBench %s %d" %(bench,mode)
    print(command)
    subprocess.call(command, shell=True, stdout=open('/dev/null', 'w'), stderr=subprocess.STDOUT)


if __name__ == '__main__':
    process_num = 10
    list_of_arguments = sys.argv
    if len(list_of_arguments) > 1:
        process_num = int(list_of_arguments[1])

    pool0 = multiprocessing.Pool(processes=process_num)

    for round in range(3):
        for mode in range(5):
            for bench in ["bling", "chemnum", "clojure", "curta", "firstOrder", "uri", "sixpath", "jsonmwn","jsonParser"]:
                pool0.apply_async(synthesis, (bench, mode))
    pool0.close()
    pool0.join()


