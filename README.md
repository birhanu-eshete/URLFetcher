#Compile:
- <code>javac URLFetcher.java</code>

#Execute:

- Command Format: <code> java URLFetcher url_list.txt start_index end_index save_as</code>

where:
- url_list.txt is the file containing the the list of URLs (one URL per line)
- start_index is the initial line number in the URL list (put 0 to start from the first line)
- end_index is the last line number in the URL list
- save_as is the file extension with which the content is saved (e.g. txt)

Suppose you got a url list of 20 URLs in a file list.txt and you want to fetch the content of the last 15 and save content in a text file. The command will be: <code>java URLFetcher list.txt 6 20 txt</code>
