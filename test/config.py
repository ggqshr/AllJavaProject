#encoding: utf-8
from __builtin__ import str
def get_wifi_data(data):
    splitChar='\1'
    index = data.find(splitChar)
    f = open('../temp/result.txt','a')
    if(index != -1):
        lastindex = data.rfind(splitChar)
        result = lastindex-index
        if(result-1>12):
            rdata=data[index+1:lastindex]
            datalist = rdata.split(splitChar)
            for i in range(1,len(datalist)-1):
                if(len(datalist[i])>12):
                    mac=datalist[i][0:12]
#                     mac = str.encode(mac)
                    print datalist[i]
                    if(mac=='d8c46a294805' or mac=='3cb6b79db2f6'):
                        f.write(mac+"  ")
                        f.flush()
                        rssi=[]
                        for j in range(12,len(datalist[i])):
                            value = str(ord(datalist[i][j]))
                            rssi.append(value)
                            f.write(value+"  ")
                        f.write('\n')
                        f.flush()
                        print rssi
    f.close()
