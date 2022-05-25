/***************************************************************************
 *                                  _   _ ____  _
 *  Project                     ___| | | |  _ \| |
 *                             / __| | | | |_) | |
 *                            | (__| |_| |  _ <| |___
 *                             \___|\___/|_| \_\_____|
 *
 * Copyright (C) 1998 - 2020, Daniel Stenberg, <daniel@haxx.se>, et al.
 *
 * This software is licensed as described in the file COPYING, which
 * you should have received as part of this distribution. The terms
 * are also available at https://curl.se/docs/copyright.html.
 *
 * You may opt to use, copy, modify, merge, publish, distribute and/or sell
 * copies of the Software, and permit persons to whom the Software is
 * furnished to do so, under the terms of the COPYING file.
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY
 * KIND, either express or implied.
 *
 * Edited by Caroline Lemieux <clemieux@cs.berkeley.edu>.
 *
 ***************************************************************************/ 
/* <DESC>
 * Set working URL from the file given as the first argument in argv.
 * </DESC>
 */ 
#include <stdio.h>
#include <curl/curl.h>
/* 
#if !CURL_AT_LEAST_VERSION(7, 62, 0)
#error "this example requires curl 7.62.0 or later"
#endif
 */

int main(int argc, char ** argv)
{
  if (argc != 2){
    return 2;
  }
  char in_buf[1025];
  char * filename = argv[1];
  FILE *fp = fopen(filename, "r");
  if (fp != NULL)
  {
	  size_t read_len = fread(in_buf, sizeof(char), 1024, fp);
	  in_buf[read_len++] = '\0';
  }
  else {
	  return 2;
  }

  int ret = 0;


  CURLU *urlp;
  CURLUcode uc;
 
  /* init Curl URL */ 
  urlp = curl_url();
  uc = curl_url_set(urlp, CURLUPART_URL,
                    in_buf, 0);
 
  if(uc) {
    fprintf(stderr, "curl_url_set() failed: %i\n", uc);
    ret = 1;
    goto cleanup;
  }
 
  cleanup:
  curl_url_cleanup(urlp);
  return ret;
}
