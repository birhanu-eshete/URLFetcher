import java.net.*;
import java.io.*;
/**
 *
 * @author birhanum
 This application accepts a file with list of URLs on different lines and the file extension with which to save the fetched URL content.
 It creates one file per each URL and saves the corresponding URL content in the file under a separate directory.
 If the file containing the URL list is under the same directory as the URLFetcher class file,  you simply give the file name. Otherwise, you
have to provide the absolute path of the file. For example for a file url_list.txt start index and end index and you want the fetched content in text files,  you invoke this application as:
java URLFetcher url_list.txt start_index end_index txt 

Note that this class may only be used for educational purposes and is provided without any warranty that is works under another context.
*/
public class URLFetcher{

  public static void main(String [] args) throws IOException{
                
                /* Declare URL variable*/
                URL url;
                /* define input stream */
                InputStream is = null;
                /* define datainput stream */
                DataInputStream dis;
                int numURLs=0,i,start, end;
                String line, urlList, fileExtension, oneURL, strDirectory="fetched";
                String urlsList[] =new String[1000000];
		urlList=args[0];
		start =Integer.parseInt(args[1]);
		end =Integer.parseInt(args[2]);
                fileExtension =args[3];
                BufferedReader br = new BufferedReader(new FileReader(urlList));
		boolean success = (new File(strDirectory)).mkdir();
    		if (success) {
      			System.out.println("Saving fetched URLs under : " + strDirectory+"/" );
   		 }
	
       		 i=0;
		 while((oneURL =br.readLine())!=null){
           		urlsList[i]=oneURL;
			i++;
                 }
   		 numURLs = i;
		if (end-start <=numURLs && end-start>=0){
		 for (i=start;i<end;i++){
		  try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(strDirectory+"/"+"url_"+(i+1)+"."+fileExtension));
                        url = new URL(urlsList[i+1]);
                        is = url.openStream();
                        dis = new DataInputStream(new BufferedInputStream(is));
                        while ((line = dis.readLine()) != null) {
                            out.write(line+"\n");
                            }
			    System.out.println(urlsList[i+1]+"...done");
                            out.close();
                        } 
                          catch (MalformedURLException mue) {
                            System.out.println(mue.getMessage());
                        } catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                                }
	                finally {
                        try {
                            is.close();
                            } catch (IOException ioe) {
                        }
                    }
                }     
            }
       }
   }
