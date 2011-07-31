import os
import time

if __name__=='__main__':
  import curses

  win=curses.initscr()
  win.clear()

  try:
   while True:
    sec=int(time.time())
    esec=sec%86400
    s=str(esec)
    while len(s)<5:
      s='0'+s
    h=s[:1]
    m=s[1:3]
    s=s[3:]
#    s='~'+h+':'+m+':'+s
    s='~'+h+m+'.'+s

    win.addnstr(11, 35, s, len(s))
    win.move(0,0)
    win.refresh()
    time.sleep(1)
  except:
    curses.endwin()

