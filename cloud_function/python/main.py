def hello_world(request):
    return al_test()
    
def al_test():
    import psycopg2
    conn = psycopg2.connect(database="public",user="user",password="password",host="192.168.1.1",port="5432")
    cursor=conn.cursor()
    cursor.execute("select version() as a")
    rows=cursor.fetchall()
    r = "test"
    for row in rows:
        r = row[0]
    return r
