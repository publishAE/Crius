
modeName = ['final', 'token', 'GADSE', 'DSE', 'exchange_GADSE']



def average_data(bench, mode):
    with open("results/" +bench +"/time&precision") as file_obj:
        lines = file_obj.readlines()
    precisions = []
    exec_times = []
    for line in lines:
        content = line.split(' ')
        if content.__contains__(modeName[mode]):
            precisions.append(float(content[5].replace('\n', '')))
            exec_times.append(float(content[1]))
    precision = 0
    exec_time = 0
    for p in precisions:
        precision += p
    precision = precision /3

    for t in exec_times:
        exec_time += t
    exec_time = exec_time /3


    with open("results/" +bench +"/" +modeName[mode ] +"-recall", encoding='utf-8') as file_obj:
        line = file_obj.readline()
        while not line.__contains__('Recall:'):
            line = file_obj.readline()
            if not line :
                break
        recall = float(line.split(' ')[1])
    f1 = 2* precision * recall / (precision + recall)
    return recall, precision, f1, exec_time


if __name__ == '__main__':

    for mode in range(5):
        f = open('results/results' + str(mode) + ".csv", 'w+')
        for bench in ["bling", "chemnum", "clojure", "curta", "firstOrder", "uri", "sixpath", "jsonmwn","jsonParser"]:
            print(bench + "_" + modeName[mode])
            print("%s %.2f & %.2f & %.2f & %.2f" % (bench, average_data(bench, mode)[0], average_data(bench, mode)[1],average_data(bench, mode)[2], average_data(bench, mode)[3] ), file=f)
    f.close()
