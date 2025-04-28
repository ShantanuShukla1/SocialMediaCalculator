package prj5;

import cs2.*;

import java.awt.Color;
import java.text.DecimalFormat;

/**
 * GUI that displays the first three months
 * 
 * @author aanchalp
 * @version 12/6/24
 * @author Shantanu Shukla
 * @version 12-4-24
 */
public class GUIwindow
{
    private Window window;
    private Button quitButton;
    private Button sortByChannelName;
    private Button sortByEngagementRate;
    private Button jan;
    private Button feb;
    private Button mar;
    private Button firstQuarter;
    private Button ter;
    private Button rer;
    private Button currentMonth;
    private Button currentSort;
    private Button currentRate;
    private DoublyLinkedList<MediaStats> dll;
    private DoublyLinkedList<MediaStats> listByMonth;
    private static final int DISTANCE = 200;
    private static final int MULTIPLIER = 7;
    private static final int MULTIPLIER2 = 2;
    private static final int WIDTH = 20;

    /**
     * Instantiates windows and buttons
     */

    public GUIwindow(DoublyLinkedList<MediaStats> smc)
    {
        window = new Window("Social Media Vis");
        quitButton = new Button("Quit");
        sortByChannelName = new Button("Sort by Channel Name");
        sortByEngagementRate = new Button("Sort by Engagement Rate");
        jan = new Button("January");
        feb = new Button("February");
        mar = new Button("March");
        firstQuarter = new Button("First Quarter (Jan - March)");
        ter = new Button("Traditional Engagement Rate");
        rer = new Button("Reach Engagement Rate");

        window.addButton(sortByChannelName, WindowSide.NORTH);
        window.addButton(sortByEngagementRate, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(jan, WindowSide.SOUTH);
        window.addButton(feb, WindowSide.SOUTH);
        window.addButton(mar, WindowSide.SOUTH);
        window.addButton(firstQuarter, WindowSide.SOUTH);
        window.addButton(ter, WindowSide.WEST);
        window.addButton(rer, WindowSide.WEST);

        window.setSize(1200, 800);
        quitButton.onClick(this, "clickedQuit");

        jan.onClick(this, "update");
        feb.onClick(this, "update");
        mar.onClick(this, "update");
        firstQuarter.onClick(this, "update");

        ter.onClick(this, "update");
        rer.onClick(this, "update");

        sortByChannelName.onClick(this, "update");
        sortByEngagementRate.onClick(this, "update");

        currentMonth = jan;
        currentRate = ter;
        currentSort = sortByChannelName;
        dll = smc;
        clickedMonth(currentMonth);
        clickedRate(currentRate);
        clickedSort(currentSort);
    }


    /**
     * Returns the window
     * 
     * @return window The GUI window
     */

    public Window getWindow()
    {
        return window;
    }


    /**
     * Method for quitting program
     * 
     * @param button
     *            Quit button
     */

    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * Updates the window based on the msot recent buttons pressed
     * 
     * @param button
     *            Most recent button pressed
     */

    public void update(Button button)
    {
        window.removeAllShapes();
        if (button == jan || button == feb || button == mar
            || button == firstQuarter)
        {
            currentMonth = button;
        }
        if (button == ter || button == rer)
        {
            currentRate = button;
        }
        if (button == sortByChannelName || button == sortByEngagementRate)
        {
            currentSort = button;
        }
        clickedMonth(currentMonth);
        clickedRate(currentRate);
        clickedSort(currentSort);
    }


    /**
     * Shows the monthly stats
     * 
     * @param button
     *            Current setting for time period
     */

    public void clickedMonth(Button button)
    {
        TextShape january = new TextShape(10, 10, "January", Color.black);
        TextShape february = new TextShape(10, 10, "February", Color.black);
        TextShape march = new TextShape(10, 10, "March", Color.black);

        // filter by month

        if (button == jan)
        {
            listByMonth = InputFileReader.filterByMonth("January", dll);
            window.addShape(january);

        }
        if (button == feb)
        {
            listByMonth = InputFileReader.filterByMonth("February", dll);
            window.addShape(february);

        }
        if (button == mar)
        {
            listByMonth = InputFileReader.filterByMonth("March", dll);
            window.addShape(march);

        }
        if (button == firstQuarter)
        {
            TextShape quarter =
                new TextShape(10, 10, "First Quarter (Jan-March)", Color.black);
            listByMonth = InputFileReader.filterByMonth("Q1", dll);
            window.addShape(quarter);

        }

        currentMonth = button;
    }


    /**
     * Shows the engagement rates
     * 
     * @button Current type of rate being displayed
     */

    public void clickedRate(Button button)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        TextShape traditional =
            new TextShape(10, 25, "Traditional Engagement Rate", Color.black);
        TextShape reach =
            new TextShape(10, 25, "Reach Engagement Rate", Color.black);
        TextShape first;
        TextShape second;
        TextShape third;
        TextShape fourth;

        if (button == ter)
        {
            window.addShape(traditional);

            first = new TextShape(
                DISTANCE,
                430,
                String.valueOf(
                    df.format(listByMonth.getEntry(0).getEngagementRate())));
            second = new TextShape(
                2 * DISTANCE,
                430,
                String.valueOf(
                    df.format(listByMonth.getEntry(1).getEngagementRate())));
            third = new TextShape(
                3 * DISTANCE,
                430,
                String.valueOf(
                    df.format(listByMonth.getEntry(2).getEngagementRate())));
            fourth = new TextShape(
                4 * DISTANCE,
                430,
                String.valueOf(
                    df.format(listByMonth.getEntry(3).getEngagementRate())));
        }

        else
        {
            window.addShape(reach);

            first = new TextShape(
                DISTANCE,
                430,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(0).getReachEngagementRate())));
            second = new TextShape(
                2 * DISTANCE,
                430,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(1).getReachEngagementRate())));
            third = new TextShape(
                3 * DISTANCE,
                430,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(2).getReachEngagementRate())));
            fourth = new TextShape(
                4 * DISTANCE,
                430,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(3).getReachEngagementRate())));

        }

        currentRate = button;

    }


    /**
     * Shows the graph in the correct sorter orders
     * 
     * @param button
     *            Most recent sorting type requested
     */

    public void clickedSort(Button button)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        TextShape channel =
            new TextShape(10, 40, "Sorting by Channel Name", Color.black);
        TextShape rate =
            new TextShape(10, 40, "Sorting by Engagement Rate", Color.black);
        Shape first;
        Shape second;
        Shape third;
        Shape fourth;

        TextShape rate1;
        TextShape rate2;
        TextShape rate3;
        TextShape rate4;

        if (button == sortByChannelName)
        {
            window.addShape(channel);
            listByMonth = InputFileReader.sortByChannel(listByMonth);
        }
        else
        {
            window.addShape(rate);
            if (currentRate == ter)
            {
                listByMonth = InputFileReader.sortByTrad(listByMonth);
            }
            else
            {
                listByMonth = InputFileReader.sortByReach(listByMonth);
            }
        }

        if (currentRate == ter)
        {
            rate1 = new TextShape(
                DISTANCE,
                650,
                String.valueOf(
                    df.format(listByMonth.getEntry(0).getEngagementRate())));
            rate2 = new TextShape(
                2 * DISTANCE,
                650,
                String.valueOf(
                    df.format(listByMonth.getEntry(1).getEngagementRate())));
            rate3 = new TextShape(
                3 * DISTANCE,
                650,
                String.valueOf(
                    df.format(listByMonth.getEntry(2).getEngagementRate())));
            rate4 = new TextShape(
                4 * DISTANCE,
                650,
                String.valueOf(
                    df.format(listByMonth.getEntry(3).getEngagementRate())));

            first = new Shape(
                DISTANCE,
                640 - (int)(listByMonth.getEntry(0).getEngagementRate()
                    * MULTIPLIER2),
                WIDTH,
                (int)(listByMonth.getEntry(0).getEngagementRate()
                    * MULTIPLIER2),
                Color.red);
            second = new Shape(
                2 * DISTANCE,
                640 - (int)(listByMonth.getEntry(1).getEngagementRate()
                    * MULTIPLIER2),
                WIDTH,
                (int)(listByMonth.getEntry(1).getEngagementRate()
                    * MULTIPLIER2),
                Color.orange);
            third = new Shape(
                3 * DISTANCE,
                640 - (int)(listByMonth.getEntry(2).getEngagementRate()
                    * MULTIPLIER2),
                WIDTH,
                (int)(listByMonth.getEntry(2).getEngagementRate()
                    * MULTIPLIER2),
                Color.blue);
            fourth = new Shape(
                4 * DISTANCE,
                640 - (int)(listByMonth.getEntry(3).getEngagementRate()
                    * MULTIPLIER2),
                WIDTH,
                (int)(listByMonth.getEntry(3).getEngagementRate()
                    * MULTIPLIER2),
                Color.green);
        }
        else
        {
            rate1 = new TextShape(
                DISTANCE,
                650,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(0).getReachEngagementRate())));
            rate2 = new TextShape(
                2 * DISTANCE,
                650,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(1).getReachEngagementRate())));
            rate3 = new TextShape(
                3 * DISTANCE,
                650,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(2).getReachEngagementRate())));
            rate4 = new TextShape(
                4 * DISTANCE,
                650,
                String.valueOf(
                    df.format(
                        listByMonth.getEntry(3).getReachEngagementRate())));

            first = new Shape(
                DISTANCE,
                (640 - (int)(listByMonth.getEntry(0).getReachEngagementRate()
                    * MULTIPLIER)),
                WIDTH,
                (int)(listByMonth.getEntry(0).getReachEngagementRate()
                    * MULTIPLIER),
                Color.red);
            second = new Shape(
                2 * DISTANCE,
                640 - (int)(listByMonth.getEntry(1).getReachEngagementRate()
                    * MULTIPLIER),
                WIDTH,
                (int)(listByMonth.getEntry(1).getReachEngagementRate()
                    * MULTIPLIER),
                Color.orange);
            third = new Shape(
                3 * DISTANCE,
                640 - (int)(listByMonth.getEntry(2).getReachEngagementRate()
                    * MULTIPLIER),
                WIDTH,
                (int)(listByMonth.getEntry(2).getReachEngagementRate()
                    * MULTIPLIER),
                Color.blue);
            fourth = new Shape(
                4 * DISTANCE,
                640 - (int)(listByMonth.getEntry(3).getReachEngagementRate()
                    * MULTIPLIER),
                WIDTH,
                (int)(listByMonth.getEntry(3).getReachEngagementRate()
                    * MULTIPLIER),
                Color.green);
        }

        TextShape channel1 = new TextShape(
            DISTANCE,
            670,
            listByMonth.getEntry(0).getChannelName().toString());
        TextShape channel2 = new TextShape(
            2 * DISTANCE,
            670,
            listByMonth.getEntry(1).getChannelName().toString());
        TextShape channel3 = new TextShape(
            3 * DISTANCE,
            670,
            listByMonth.getEntry(2).getChannelName().toString());
        TextShape channel4 = new TextShape(
            4 * DISTANCE,
            670,
            listByMonth.getEntry(3).getChannelName().toString());
        window.addShape(channel1);
        window.addShape(channel2);
        window.addShape(channel3);
        window.addShape(channel4);

        window.addShape(rate1);
        window.addShape(rate2);
        window.addShape(rate3);
        window.addShape(rate4);

        window.addShape(first);
        window.addShape(second);
        window.addShape(third);
        window.addShape(fourth);

        currentSort = button;
    }


    /**
     * Sets the dll to a given param
     * 
     * @param list
     *            List for dll to be set to
     */

    public void setMediaStatsList(DoublyLinkedList<MediaStats> list)
    {
        dll = list;
    }
}
