#encoding: utf-8
import MySQLdb

conn=MySQLdb.connect(host='127.0.0.1',port=3306,
    user='root',
    passwd='123',
    db='python_test',
    charset='utf8',
    )
cursor=conn.cursor()
sql='select * from t1'
# sql_insert='inser into t1 values(5,\'mbw\')'
rs=()
try:
#     cursor.execute(sql_insert)
    print cursor.rowcount
    cursor.execute(sql)
    print cursor.rowcount
    rs=cursor.fetchall()
    conn.commit()
except Exception as e:
    print e
    conn.rollback()
for i in rs :
    print i

cursor.close()
conn.close()
