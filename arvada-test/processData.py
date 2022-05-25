
precision = []
recall = []

def readFile(fileName) :
    with open(fileName, encoding='utf-8') as file_obj:
        line = file_obj.readline()
        while not line.__contains__('Recall:'):
            line = file_obj.readline()
            if not line :
                break
        # print(fileName + line)
        if not line:
            return
        recall.append(float(line.split(' ')[1].replace(',', '')))
        precision.append(float(line.split(' ')[3].replace('\n','')))


def computeF1():
    f1 = []
    for i in range(len(precision)):
        p = precision[i]
        r = recall[i]
        if p == 0 or r == 0:
            continue
        f1.append(2*p*r/(p+r))
    return averave(f1)


def averave(list):
    res = 0
    if len(list).__eq__(0):
        return 0, 0
    for element in list:
        res+=element
    res = res / len(list)
    std = 0
    for element in list:
        std += pow(element - res, 2)
    std = pow(std/len(list), .5)
    return res, std



if __name__ == '__main__':

    for inputs in ["GADSE", "DSE"]:
        f = open('results_' + inputs + ".csv", 'w+')
        for bench in ["bling", "chemnum", "clojure", "curta", "firstOrder", "uri", "Sixpath", "Jsonmwn", "JsonParser"]:
            precision = []
            recall = []
            for i in range(10):
                # print(inputs+"_"+bench+"_"+str(i)+".log.eval")
                readFile("arvada-results/"+inputs+"_"+bench+"_"+str(i)+".log.eval")
            print(inputs+"_"+bench)
            print("p:%.2f +- %.2f" %averave(precision))
            print("r:%.2f +- %.2f" %averave(recall))
            print("f1:%.2f +- %.2f" %computeF1())
            if bench == 'Sixpath':
                bench = 'sixpath'
            if bench == 'Jsonmwn':
                bench = 'jsonmwn'
            if bench == 'JsonParser' :
                bench = 'jsonParser'
            print("%s %.2f & %.2f & %.2f & %.2f" %(bench,  averave(recall)[0], averave(precision)[0], computeF1()[0], 1.0), file = f)