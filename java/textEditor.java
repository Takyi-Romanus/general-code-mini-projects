package java;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Hashtable;

import javax.swing.undo.StateEdit;
import javax.swing.undo.UndoManager;

import org.w3c.dom.Text;

public class textEditor {
    class undoableTextArea extends textArea implements stateEditable {
        private final static String KEY_STATE="undoableTextArea";
        private boolean textChanged=false;
        private UndoManager undoManager;
        private StateEdit currentEdit;

        public undoableTextArea(){
            super();
            initUndoable();
        }

        public undoableTextArea(String string){
            super(string);
            initUndoable();
        }

        public undoableTextArea(int rows, int columns){
            super(rows, columns);
            initUndoable();
        }

        public undoableTextArea(String string, int rows, int columns){
            super(string, rows, columns);
            initUndoable();
        }

        public undoableTextArea(String string, int rows, int columns, int scrollbars){
            super(string, rows, columns, scrollbars);
            initUndoable();
        }

            public boolean undo(){
                try {
                    undoManager.undo();
                    return true;
                } catch (cannotUndoException e) {
                    System.out.println("cannot undo");
                    return false;
                }
            }

            public boolean redo(){
                try {
                    undoManager.redo();
                    return true;
                } catch (cannotRedoException e) {
                    System.out.println("cannot redo");
                    return false;
                }
            }

            public void restoreState(Hashtable state){
                Object data=state.get(KEY_STATE);
                if (data=null) {
                    setText((String)data);                    
                }
            }

            private void takeSnapshot(){
                if (textChanged) {
                    currentEdit.end();
                    undoManager.addEdit(currentEdit);
                    textChanged=false;
                    currentEdit= new stateEdit(this);
                }
            }

            private void initUndoable(){
                undoManager= new UndoManager();
                currentEdit= new stateEdit(this);
                addKeyListener(new keyAdapter(){
                    public void keyPressed(KeyEvent event){
                        if (event.isActionKey()) {
                            takeSnapshot();
                        }
                    }
                });

                addFocusListener(new focusAdapter(){
                    public void focusLost(focusEvent fe){
                        takeSnapshot();
                    }
                });

                addTextListener(new TextListener(){
                    public void textValueChanged(textEvent e){
                        textChanged=true;
                        takeSnapshot();
                    }
                });
                
            }
    }

    public class TextEditor extends Frame {
        boolean b = true;
        Frame fm;
        FileDialog fd;
        Font f;
        int style=Font.PLAIN;
        int fsize=12;
        undoableTextArea txt;
        String filename,st,fn="untitled",dn;
        Clipboard Clip = getToolkit().getSystemClipboard();
        TextEditor(){
            f= new Font("Courier", style,fsize);
            setLayout(new GridLayout(1,1));
            txt = new undoableTextArea(80,25);

            txt.setFont(f);
            add(txt);
            MenuBar md = new MenuBar();
            Menu fonttype=new MenuBar("FontType");
            MenuItem one,two,three,four,five,six;
            one = new MenuItem("TimesRoman");
            two = new MenuItem("Helvetica");
            three = new MenuItem("Courier");
            four = new MenuItem("Arial");
            five = new MenuItem("Arial Black");
            six = new MenuItem("Century");

            fonttype.add(one);
            fonttype.add(two);
            fonttype.add(three);
            fonttype.add(four);
            fonttype.add(five);
            fonttype.add(six);

            one.addActionListener(new Type());
            two.addActionListener(new Type());
            three.addActionListener(new Type());
            four.addActionListener(new Type());
            five.addActionListener(new Type());
            six.addActionListener(new Type());

            Menu fontmenu = new Menu("Font");
            MenuItem boldmenu= new MenuItem("Bold");
            MenuItem plainmenu= new MenuItem("Plain");
            MenuItem italicmenu= new MenuItem("Italic");

            fontmenu.add(boldmenu);
            fontmenu.add(plainmenu);
            fontmenu.add(italicmenu);

            boldmenu.addActionListener(new FM());
            plainmenu.addActionListener(new FM());
            italicmenu.addActionListener(new FM());

            Menu size = new Menu("Size");
            MenuItem=s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
            s1= new MenuItem("10");
            s2= new MenuItem("12");
            s3= new MenuItem("14");
            s4= new MenuItem("16");
            s5= new MenuItem("18");
            s6= new MenuItem("20");
            s7= new MenuItem("22");
            s8= new MenuItem("24");
            s9= new MenuItem("26");
            s10= new MenuItem("28");

            Size.add(s1);
            Size.add(s2);   
            Size.add(s3);
            Size.add(s4);
            Size.add(s5);
            Size.add(s6);
            Size.add(s7);
            Size.add(s8);
            Size.add(s9);
            Size.add(s10);

            s1.addActionListener(new Size());
            s2.addActionListener(new Size());
            s3.addActionListener(new Size());
            s4.addActionListener(new Size());
            s5.addActionListener(new Size());
            s6.addActionListener(new Size());
            s7.addActionListener(new Size());
            s8.addActionListener(new Size());
            s9.addActionListener(new Size());
            s10.addActionListener(new Size());

            Menu file = new Menu("File");
            MenuItem n = new MenuItem("New", new MenuShortcut(KeyEvent.VK_N));
            MenuItem o = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_O));
            MenuItem s = new MenuItem("Save", new MenuShortcut(KeyEvent.VK_S));
            MenuItem e = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_E));
            n.addActionListener(new New());
            file.add(n);
            o.addActionListener(new Open());
            file.add(o);
            s.addActionListener(new Save());
            file.add(s);
            e.addActionListener(new Exit());
            file.add(e);
            mb.add(file);
            addWindowListener(new Win());
            Menu edit = new Menu("Edit");
            MenuItem v = new MenuItem("Paste", new MenuShortcut(KeyEvent.VK_V));
            MenuItem c = new MenuItem("Copy", new MenuShortcut(KeyEvent.VK_C));
            MenuItem x = new MenuItem("Cut", new MenuShortcut(KeyEvent.VK_X));
            paste.addActionListener(new Paste());
            edit.add(paste);
            copy.addActionListener(new Copy());
            edit.add(copy);
            cut.addActionListener(new Cut());
            edit.add(cut);
            Menu color = new Menu("Color");
            MenuItem bg = new MenuItem("Background");
            MenuItem fg = new MenuItem("Foreground");
            bg.addActionListener(new BC());
            fg.addActionListener(new FC());
            color.add(bg);
            color.add(fg);
            Menu undo = new Menu("Undo&Redo");
            MenuItem un= new MenuItem("Undo");
            MenuItem re= new MenuItem("Redo");
            un.addActionListener(new Undo());
            undo.add(un);
            re.addActionListener(new Redo());
            undo.add(re);
            mb.add(fonttype);
            mb.add(fontmenu);
            mb.add(edit);
            mb.add(color);
            mb.add(undo);
            mb.add(size);
            setMenuBar(mb);

            myListener myList = new myListener();
            addWindowListener(myList);

        }

        class WW implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String se=e.getActionCommand();
                if (se.equals("Undo"))
                txt.undo();
                if (se.equals("Redo"))
                txt.redo();
            }
        }

        class myListener extends WindowAdapter{
            public void windowClosing(WindowEvent we){
                if(!b)
                System.exit(0);
            }
        }

        class new implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                txt.setText(" ");
                setTitle(filename);
                fn="untitled";
            }
        }

        class Open implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                FileDialog fd = new FileDialog(textEditor.this,"Select");
                fd.setVisible(true);
                filename=fd.getFile();
                dn=fd.getDirectory();
                if (filename!=null) {
                    setTitle(filename);
                    fn=filename;
                    txt.setText(" ");
                    try {
                        FileInputStream fin = new FileInputStream(dn+filename);
                        int i=0;
                        while ((i=fin.read())!=-1) {
                            txt.append(String.valueOf((char)i));
                        }
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }
                }
            }
        }

        class Save implements ActionListener {
            public void actionPerformed (ActionEvent ae){
                FileDialog fd = new FileDialog(textEditor.this, "SaveFile", FileDialog);
                fd.setFile(fn);
                fd.setDirectory(dn);
                fd.show();

                if (fd.getFile()!=null) {
                    filename = fd.getDirectory()+fd.getFile();
                    setTitle(filename);
                    writeFile();
                    txt.requestFocus();                }
            }
        }

        class Exit implements ActionListener {
        public void ActionPerformed(ActionEvent ae){
            System.exit(0);
            }
        }

        void readFile() {
            BufferedReader d;
            StringBuffer fb=new StringBuffer();
            try {
                d=new BufferedReader(new FileReader(filename));
                String line;
                while ((line=d.readLine())!=null);
                sb.append(line+" ");
                txt.setText(sb.toString());
                d.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }catch (IOException e){}
        }

        public void writeFile(){
            try {
                DataOutputStream d =new DataOutputStream(new FileOutputStream(filename));
                String line= txt.getText();
                BufferedReader br = new BufferedReader(new StringReader(line));
                while ((line=br.readLine())!=null) {
                    d.writeBytes(line+"");
                }d.close();
            } catch (Exception e) {
                System.out.println("file not found");
            }
        }

        class Cut implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                String sel= txt.getSelectedText();
                StringSelection ss= new StringSelection(sel);
                Clip.setContent(ss,ss);
                txt.replaceRange("",txt.getSelectionStart(), txt.getSelectionEnd());
            }
        }

        class Copy implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                String sel=txt.selectText();
                StringSelection ClipString=new StringSelection(sel);
                Clip.setContents(ClipString,ClipString);
            }
        }

        class Paste implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                Transferable
                ClipTran=clip.getContents(TextEditor.this);
                try {
                    String sel = (String)cliptran.getTransferData(DataFlavor.stringFlavor);
                    txt.replaceRange(sel, txt.getSelectionStart(), txt.getSelectionEnd());
                } catch (Exception e) {
                    System.out.println("Not Starting Flavour");
                }
            }
        }

        class Win extends WindowAdapter{
            public void windowClosing(WindowEvent we){
                confirmDialog cd=new confirmDialog();
                if (!b) {
                    System.exit(0);
                }
            }
        }
    }
}
