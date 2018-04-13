#encoding: utf-8
from flask import Flask, jsonify, request, abort
import json
import threading
from config import get_wifi_data
from macpath import join
app=Flask(__name__) #创建Flask类的一个实例


@app.route('/', methods=['GET','POST'])
def index():
    if request.method == 'GET':
        return "ok"
    if request.method == 'POST':
        thread = []
        date = request.values
#         for(key,value) in date.items():
#             print key,value
        t1 = threading.Thread(target=get_wifi_data,args=(date['data'],))
        thread.append(t1)
        for t in thread:
            t.setDaemon(True)
            t1.start()
        t.join()
        return u'ok'
        
    
@app.route('/user/<name>')
def user(name):
    return "<h1>hello %s</h1>"%name
if __name__=='__main__': #Python入口程序
    app.run(host='192.168.191.1',port=8000) #使其运行于本地服务器上