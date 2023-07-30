public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;
    private boolean burning = false;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }
    
    public boolean inOnett(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    /*
        recursiveFire method here
     */
    
    public void recursiveFire(int x, int y){
        if (!inOnett(x,y) || myGrid[y][x].getStatus() !=FireCell.GREEN) {
            return;
        }
        if (y == 0)
             burning = true;
        
        myGrid[y][x].setStatus(FireCell.BURNING);
        myView.updateView(myGrid);

        recursiveFire(x + 1, y + 0);
        recursiveFire(x + 0, y + 1);
        recursiveFire(x + -1, y + 0);
        recursiveFire(x + 0, y + -1);
    }

    public void solve()
    {
        for(int i = 0; i< SIZE; i++){
            recursiveFire(i, SIZE-i);
        }
        if(burning){
            System.out.println("Onett is in trouble!");
        }
        else{
            System.out.println("Onett is safe.");
        }
        myView.updateView(myGrid);
    }

}
