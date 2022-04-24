package classes;

public class ButtonId {

   private int page;
   private int column;
   private int row;

   public ButtonId(int page, int column, int row) {
      this.page = page;
      this.column = column;
      this.row = row;
   }

   public int getPage() {
      return this.page;
   }
   public void setPage(int page) {
      this.page = page;
   }
   public int getColumn() {
      return this.column;
   }
   public void setColumn(int column) {
      this.column = column;
   }
   public int getRow() {
      return this.row;
   }
   public void setRow(int row) {
      this.row = row;
   }

}
