Shoes.app :width => 300, :height => 100 do
  def calc_time
    t = Time.new.utc.to_i%86400
    t = t.to_s
    t = "@ "+t[0..2]+" : "+t[3..5]
  end
  background "#BE8"  
  stack do
    @title = title "New Internet Time!",
      :align => "center",
      :size => 15

    @time = para calc_time,
      :align => "center",
      :size => 13
      
    every 1 do
      @time.replace(calc_time)
    end
  end
end
