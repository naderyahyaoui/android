package company.my.semer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ji on 08/11/2015.
 */
public class ClientAdapter extends ArrayAdapter<Client> {




    Context context;
    int layoutResourceId;
    List<Client> clients = null;


    public ClientAdapter(Context context, int layoutResourceId,
                          List<Client> clients) {
        super(context, layoutResourceId, clients);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.clients = clients;

    }

    @SuppressLint("SdCardPath")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ClientHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ClientHolder();

            holder.firstName = (TextView) row.findViewById(R.id.tv_firstName);
            holder.lastName = (TextView) row.findViewById(R.id.tv_lastName);
            row.setTag(holder);
        } else {
            holder = (ClientHolder) row.getTag();
        }
        Client client = clients.get(position);


//		Picasso.with(context).load(teacher.getImgPath())
//				.into(holder.teacherImg);
        holder.firstName.setText(client.getLastName() + " "
                + client.getFirstName());
        holder.lastName.setText(client.getLastName());
        return row;
    }

    public class ClientHolder {

        TextView firstName;
        TextView lastName;
    }





}
