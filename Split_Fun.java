
public class Split_Fun {

	public static void main(String[] args) {
		String s = ",_! ! _@?'  !?_,'! '_'_@.... ''?. ?_ !?. ..!'!?@,?@',?_@'!, !!?_,@?,'@@',, !.? @@@@!!?' _, @???_,@ !_@!'!!!__!??'!. _. ,@! !.?'@,' '_!@@,'?' '?' ''_? '!!'?_?,._!..@_,_', ',',, !!__!_@,.! '?...  ?_? ._ ?' _! '?_..,,''.'@'??.??' @'.?' ?'_.'.'_ .'??@',_@_ , ?! , ._ . ',_'@..' ?,?,!_'',',,,?,..',.?,?_',..@?.,_ .@_?_ ,',.?_!'.??'_@__!!!'._!!__'? .?,._'', @@?!@ '?_ .@  .!!!' .'.', _!''!_@.@..@',@? @?. .@'.,@ , !'! @,@.@. ?,'_!,_'_,'! @_,_@._'?'',!_@ ,'?.@ _!__@'. '?_, ?@_,,.,.@',@!!!@ !?!@ '@_'_ _'  @_? ,_. .@@@ '.  '!@  ._ ,__!__', '._?.,,, ,!.,!?? ??. ?@_  ,@'_@'!.,@@. @@,, ?_??!' !,@'?@!!@@'_ ?'@!.@', !?.'@' _'! @ ?.,., ?' ''@ ?_ __! ! '! . ,.@,'?.?__'__@..@'!@.@ _  .!! !?_ _.?,  ''_._! ? !,_ ,, ,@!?@,@?,. _@ @_'?!._,'_?!,??.?@,.!!' .!..',._'?  '_,'?@ _!.,_,.!?_ ?,,'@!!?@ @@!@.?_'!_.?!@ ??!' ,,,.,!_?.?.,!_ _ _.,?!_.'_ ,@'? !_.?@!',.?_@ _? ? ,@!', .,??!@??? @,!_.@ !. ''!,'?  ?,!'_.,@,@!_@ ''_._@_!@.!'@ ?@!@!,_@@ . @@_.@_??!!!@, ??'!., _ !'@'_@?_.!, ''?? ..''.,,.?@@??'.,_?'?'.' '' @,?'''@@.\r\n" + 
				"";
		
		s = s.replaceAll("['_,.@!?]"," ");
		//s = s.replaceAll("//s","");
		//s = s.trim().replaceAll(" +", " ");
		
		String[] items = s.trim().split("[ !,?.\\_'@]+");
        String st[] = s.split(" ");
        if(s == null || s.trim().equals("")){
            System.out.println("0");
        }
        else{
            
            //String st[] = s.split(" ");
            System.out.println(st.length);
            for(int i=0;i<st.length;i++) {
                System.out.println(st[i]);
            }
        }
        String s1 = "This#string%contains^special*characters&.";
		//System.out.println(s1.contains("j"));
		//indexOf return -1 if String does not contain specified word and 0 if contains
	    //System.out.println(s1.indexOf("i"));	
		//System.out.println(s1.matches("[A-Za-z]+"));
        
        System.out.println(s1.replaceAll("[^a-zA-Z0-9]+", " ")); 
        System.out.println(s1.replaceAll("[-+^]*", " "));
		
	}

}
