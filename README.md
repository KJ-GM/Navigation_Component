# Navigation_Component


1) Add dependencies


```sh

def nav_version = "2.4.2"
// Java language implementation
implementation "androidx.navigation:navigation-fragment:$nav_version"
implementation "androidx.navigation:navigation-ui:$nav_version"

```

2) Make Fragments layouts + Activities

```sh

import com.example.navfinalexam.R;

import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {
    public AboutFragment() {
        super(R.layout.about_fragment);
    }
}

```

3) Create the nav_graph

```sh

a) Click on the res folder and
b) click add Android resource file
c) name it: nav_graph
d) put Resource Type: Navigation
e) Click plus phone icon and add fragments
f) go to the code and the line "tools:layout="@layout/home_fragment" for each one

    
    }

```

4) Add nav_menu

```sh

a) Click on the res folder and
b) click add Android resource file
c) name it: nav_menu
d) put Resource Type: Menu
e) Add items
    <item android:id="@+id/aboutFragment"
        android:icon="@drawable/ic_baseline_info_24"
        android:title="About"/>
        
f) For icons click on drawwable and add vectors
    
    }
```

5) Add both of these to activit_layout

```sh
<fragment
        android:id="@+id/nav_host_fragment"
        android:name="androidx.navigation.fragment.NavHostFragment"
        app:navGraph="@navigation/nav_graph"
        app:defaultNavHost="true"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomNavView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:menu="@menu/nav_menu" />
</androidx.constraintlayout.widget.Const
```

6) Add this to Main activity

```sh
    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        Set<Integer> fragmentSet = new HashSet<>();
        fragmentSet.add(R.id.homeFragment);
        fragmentSet.add(R.id.aboutFragment);
        fragmentSet.add(R.id.contactFragment);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(fragmentSet).build();

        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }
```


