
private void load_data() {
        recipeData sample = null;
        String line = "";
        String[] values = null;
        BufferedReader reader = null;

        data.clear();
        arrayList.clear();
        index = 0;
        adapter.notifyDataSetChanged();

        try{
            File dir = new File(getExternalFilesDir(null).toString(), "UserData_Recipe");

            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    Log.d("RecipeActivity", "failed to create directory");
                    return;
                }
            }

            File[] files = dir.listFiles();
            Arrays.sort(files, Comparator.comparingLong(File::lastModified));

            for(int i = files.length - 1; i >= 0 ; i--) {
                File file = new File(files[i].toString());

                Log.d("RecipeActivity", file.getPath());
                Log.d("RecipeActivity", files[i] + "::::::::");

                sample = new recipeData();

                reader = new BufferedReader(new FileReader(file.getPath()));

                line = "";
                line = reader.readLine();

                int idx = 0;

                while(line != null){
                    if(idx < 2) {
                        values = line.split(",");
                        for(int j = 0; j < values.length; j++) {
                            if(idx == 0){
                                if(j == 2 || j == DATA_TYPE.E_LENGTH.ordinal()) values[j] = values[j].replace('|', '\n');
                                sample.setData(j, values[j]);
                            }
                            else{
                                sample.setWidth_data(j, Integer.parseInt(values[j]));
                            }
                        }
                    } else if(idx < 4) {
                        values = line.split("`");
                        for(int j = 0; j < values.length; j++) {
                            if(idx == 2) {
                                //Log.d("RecipeActivity", values[j]);
                                sample.setArray_Card(values.length);
                                if(values[j].isEmpty()) break;
                                sample.setCards(j, new cardData(values[j]));
                            } else {
                                sample.setArray_Card_Super(values.length);
                                if(values[j].split(",").length == 1) break;
                                sample.setCards_Super(j, new cardData(values[j].split(",")));
                            }
                        }
                    } else {
                        values = line.split(",");
                        for(int j = 0; j < values.length; j++) {
                            if(j == values.length - 1) sample.setHot(values[j] + "\n");
                            else sample.setHot(values[j] + ",");
                        }
                    }

                    idx++;
                    line = reader.readLine();
                }

                //Log.d("RecipeActivity", sample.toString());
                addView(sample, file.getPath());
                data.add(sample);
                reader.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(reader != null)
                {
                    reader.close();
                    data_Alive = (TextView)findViewById(R.id.list_empty);
                    data_Alive.setVisibility(View.GONE);
                }
            }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
