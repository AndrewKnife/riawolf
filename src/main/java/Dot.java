public class Dot extends Object{

    private float _x;
    private float _y;
    private String _color;

    //region Konstruktoriai
    Dot(){

    }

    Dot(float x, float y){
        this._x = x;
        this._x = y;
    }

    Dot(float x, float y, String color){
        this._x = x;
        this._x = y;
        this._color = color;
    }

    Dot(String color){
        this._color = color;
    }
    //endregion



    public float get_x() {
        return _x;
    }

    public float get_y() {
        return _y;
    }

    public String get_color() {
        return _color;
    }

    public double dist(Dot b){
        return Math.sqrt(Math.pow(b.get_x() - _x, 2) + Math.pow(b.get_y() - _y, 2));
    }

    public double dist(float x, float y){
        return Math.sqrt(Math.pow(x - _x, 2) + Math.pow(y - _y, 2));
    }

    public int quarter() {
        int restult;
        if(_x >= 0){
            if(_y >= 0){
                restult = 0;
            }
            else{
                restult = 3;
            }
        }else{
            if(_y >= 0){
                restult = 1;
            }else{
                restult = 2;
            }
        }
        return restult;
    }

    public boolean isSameQuart(Dot b){
        return b.quarter() == quarter();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals;
        Dot b = (Dot)obj;
        if(b._color.equals(this._color) && b._x == this._x && b._y == this._y){
            equals = true;
        }else{
            equals = false;
        }
        return equals;
    }
}
