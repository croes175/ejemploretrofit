package miprimeraapp.com.ejemploretrofit.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import miprimeraapp.com.ejemploretrofit.R;
import miprimeraapp.com.ejemploretrofit.remove.Datos;
import miprimeraapp.com.ejemploretrofit.remove.Earthquake;
import miprimeraapp.com.ejemploretrofit.remove.MyEartQuake;

public class Adapters extends ArrayAdapter<Earthquake> {


        public List<Earthquake> datosList;
        public Context context;
        private static class ViewHolder {
            TextView Fecha;
            TextView lot1;
            TextView long1;
        }
        public Adapters(Context context, List<Earthquake> edificios) {
            super(context,0);
            this.datosList=edificios;
            this.context=context;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent){

            //Edificios edificios=getItem(position);
            ViewHolder viewHolder;
            View result;

            if(convertView==null){
                viewHolder=new ViewHolder();
                LayoutInflater inflater=LayoutInflater.from(getContext());
                convertView=inflater.inflate(R.layout.item,parent,false);
                viewHolder.Fecha=convertView.findViewById(R.id.name_item);
                viewHolder.long1=convertView.findViewById(R.id.long1);
                viewHolder.lot1=convertView.findViewById(R.id.lat);
                viewHolder.Fecha.setText(datosList.get(position).getDatetime());
                viewHolder.lot1.setText(Double.toString(datosList.get(position).getLat()));
                viewHolder.long1.setText(Double.toString(datosList.get(position).getLng()));

         /*   viewHolder.imageBuilding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,edificiosList.get(position).getNameBulding(),Toast.LENGTH_LONG).show();
                }
            });

            viewHolder.nameBuilding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,edificiosList.get(position).getNameBulding(),Toast.LENGTH_LONG).show();
                }
            });*/

                result=convertView;
                convertView.setTag(viewHolder);

            }else{
                viewHolder=(ViewHolder) convertView.getTag();
                result=convertView;

            }

            return convertView;

        }
        @Override
        public int getCount(){
            return datosList.size();
        }

    }






